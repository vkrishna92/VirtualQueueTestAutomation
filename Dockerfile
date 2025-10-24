FROM maven:3.9.6-eclipse-temurin-17
USER root
WORKDIR /app

RUN set -eux; \
    apt-get update && apt-get install -y wget unzip gnupg curl; \
    mkdir -p /usr/share/keyrings; \
    curl -fsSL https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google-chrome.gpg; \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-chrome.gpg] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list; \
    apt-get update && apt-get install -y google-chrome-stable; \
    google-chrome --version; \
    CHROME_MAJOR=$(google-chrome --version | grep -oE '[0-9]+' | head -1); \
    echo "Detected Chrome major version: ${CHROME_MAJOR}"; \
    DRIVER_VERSION=$(curl -fsSL "https://chromedriver.storage.googleapis.com/LATEST_RELEASE_${CHROME_MAJOR}" || true); \
    if [ -z "$DRIVER_VERSION" ]; then \
        echo "Could not find exact version, falling back to latest"; \
        DRIVER_VERSION=$(curl -fsSL https://chromedriver.storage.googleapis.com/LATEST_RELEASE); \
    fi; \
    echo "Installing ChromeDriver version: ${DRIVER_VERSION}"; \
    curl -fsSLO "https://chromedriver.storage.googleapis.com/${DRIVER_VERSION}/chromedriver_linux64.zip"; \
    unzip chromedriver_linux64.zip -d /usr/local/bin/; \
    chmod +x /usr/local/bin/chromedriver; \
    chromedriver --version; \
    rm chromedriver_linux64.zip; \
    rm -rf /var/lib/apt/lists/*

# Remove any old chromedriver that came from the base image
RUN rm -f /usr/bin/chromedriver || true

# Symlink the freshly downloaded driver
RUN ln -s /usr/local/bin/chromedriver /usr/bin/chromedriver

# Print versions for sanity check
RUN google-chrome --version && chromedriver --version


# Copy your test project
COPY . .
# Build and execute tests
CMD ["mvn", "test", "-DsuiteXmlFile=src/test/resources/testng-desktop-qa.xml"]