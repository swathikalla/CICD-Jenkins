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
                // Jenkins automatically checks out the code from SCM when pipeline is configured
                // This explicit checkout is optional but shown for clarity
                checkout scm
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
