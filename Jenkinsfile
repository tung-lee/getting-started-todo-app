pipeline {
    agent none
    stages {
        stage('info') {
            agent {
                label "${env.BRANCH_NAME == 'origin/main' ? 'production-server' : env.BRANCH_NAME == 'origin/dev' ? 'test-dev-battle-server' : 'default-agent'}"
            }
            steps {
                script {
                    try {
                        echo "Current branch: ${env.BRANCH_NAME}"
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
