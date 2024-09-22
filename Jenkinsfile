pipeline {
    agent {
        label 'test-dev-battle-server'
    }
    stages {
        stage('info') {
            steps {
                script {
                    try {
                        echo "Current branch: ${env.GIT_BRANCH}"
                        echo "Current agent: ${env.GIT_BRANCH == 'origin/main' ? 'production-server' : env.GIT_BRANCH == 'origin/dev' ? 'test-dev-battle-server' : 'default-agent'}"
                        echo "Selected agent: ${env.NODE_NAME}"
                        sh(script: "whoami && pwd && ls -la", label: "Environment Info")
                    } catch (Exception e) {
                        echo "An error occurred: ${e.message}"
                    }
                }
            }
        }
    }
}
