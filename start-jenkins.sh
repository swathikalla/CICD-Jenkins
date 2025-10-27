#!/bin/bash

# Start Jenkins CI/CD Environment
# This script starts Jenkins in a Docker container

echo "=========================================="
echo "  Starting Jenkins CI/CD Environment"
echo "=========================================="
echo ""

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
    echo "❌ Error: Docker is not running"
    echo "Please start Docker Desktop and try again"
    exit 1
fi

echo "✓ Docker is running"
echo ""

# Start Jenkins container
echo "Starting Jenkins container..."
docker compose up -d

if [ $? -eq 0 ]; then
    echo ""
    echo "=========================================="
    echo "  Jenkins Started Successfully!"
    echo "=========================================="
    echo ""
    echo "📝 Next Steps:"
    echo ""
    echo "1. Wait 30 seconds for Jenkins to start"
    echo ""
    echo "2. Access Jenkins at: http://localhost:8080"
    echo ""
    echo "3. Get the admin password with:"
    echo "   docker exec jenkins-cicd cat /var/jenkins_home/secrets/initialAdminPassword"
    echo ""
    echo "4. Follow the setup guide in DOCKER_SETUP.md"
    echo ""
    echo "=========================================="
    echo ""
    echo "Useful Commands:"
    echo "  View logs:    docker compose logs -f jenkins"
    echo "  Stop Jenkins: docker compose stop"
    echo "  Restart:      docker compose restart"
    echo "=========================================="
else
    echo "❌ Error: Failed to start Jenkins"
    exit 1
fi
