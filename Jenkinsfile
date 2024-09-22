pipeline {
    agent none
    stages {
        stage('info') {
            agent {
                node {
                    label {
                        if (env.BRANCH_NAME == 'main') {
                            return 'production-server'
                        } else if (env.BRANCH_NAME == 'dev') {
                            return 'test-dev-battle-server'
                        } else {
                            return 'default-agent'
                        }
                    }
                }
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
