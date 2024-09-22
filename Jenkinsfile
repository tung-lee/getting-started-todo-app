pipeline {
    agent none

    stages {
        stage('info') {
            agent {
                node {
                    label "${env.BRANCH_NAME == 'main' ? 'production-server' : env.BRANCH_NAME == 'dev' ? 'test-dev-battle-server' : 'default-agent'}"
                }
            }
            steps {
                script {
                    try {
                        echo "Current branch: ${env.BRANCH_NAME}"
                        sh(script: "whoami && pwd && ls -la", label: "Environment Info")
                    } catch (Exception e) {
                    }
                }
            }
        }
}
