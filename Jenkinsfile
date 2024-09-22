pipeline {
    agent any
    stages {
        stage('choose agent') {
            steps {
                script {
                    try {
                        echo "Current branch: ${env.GIT_BRANCH}"
                        env.LABEL = env.GIT_BRANCH == 'origin/main' ? 'production-server' : env.GIT_BRANCH == 'origin/dev' ? 'test-dev-battle-server' : 'default-agent'
                        echo "Current agent: ${env.LABEL}"
                        echo "Selected agent: ${env.NODE_NAME}"
                        sh(script: "whoami && pwd && ls -la", label: "Environment Info")
                    } catch (Exception e) {
                        echo "An error occurred: ${e.message}"
                    }
                }
            }
        }

        stage('build') {
            agent {
                label env.LABEL
            }
            steps {
                script {
                    try {
                        sh("docker ps -a")
                    } catch (Exception e) {
                        echo "An error occurred: ${e.message}"
                    }
                }
            }
        }
    }
}
