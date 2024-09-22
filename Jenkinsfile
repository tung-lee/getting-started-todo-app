pipeline {
    agent none  // We'll define the agent in each stage

    stages {
        stage('info') {
            agent {
                node {
                    label "${BRANCH_NAME == 'main' ? 'production-server' : BRANCH_NAME == 'dev' ? 'test-dev-battle-server' : 'default-agent'}"
                }
            }
            steps {
                sh(script: """ whoami;pwd;ls -la """, label: "first stage")
            }
        }
    }
}
