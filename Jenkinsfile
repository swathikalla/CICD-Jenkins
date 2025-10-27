pipeline {
    agent any

    tools {
        // Specify Maven tool configured in Jenkins Global Tool Configuration
        maven 'Maven'
        jdk 'JDK'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code from GitHub...'
                // Explicitly clone from GitHub repository
                git url: 'https://github.com/swathikalla/CICD-Jenkins.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project with Maven...'
                // Clean and install the project
                sh 'mvn clean install -DskipTests=true'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests with JUnit...'
                // Run tests and generate reports
                sh 'mvn test'
            }
            post {
                always {
                    // Publish JUnit test results
                    junit '**/target/surefire-reports/*.xml'
                    echo 'Test execution completed. Results published.'
                }
                success {
                    echo 'All tests passed successfully!'
                }
                failure {
                    echo 'Some tests failed. Please check the test reports.'
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the application...'
                sh 'mvn package -DskipTests=true'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    echo 'Building Docker image...'
                    try {
                        sh 'docker build -t java-ci-demo:${BUILD_NUMBER} .'
                        sh 'docker tag java-ci-demo:${BUILD_NUMBER} java-ci-demo:latest'
                        echo 'Docker image built successfully!'
                    } catch (Exception e) {
                        echo 'Docker build skipped or failed. This is optional.'
                        echo "Error: ${e.getMessage()}"
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed.'
            // Archive the artifacts
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
        success {
            echo 'Build completed successfully with all tests passing!'
        }
        failure {
            echo 'Build failed. Please check the logs for details.'
        }
    }
}
