pipeline {
    agent {
        label 'test-dev-battle-server'
    }
    stages {
        stage('info') {
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
