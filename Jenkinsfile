pipeline {
    agent none  // We'll define the agent in each stage

    stages {
        stage('info') {
            agent {
                node {
                    label "${env.BRANCH_NAME == 'main' ? 'production-server' : env.BRANCH_NAME == 'dev' ? 'test-dev-battle-server' : 'default-agent'}"
                }
            }
            steps {
                script {
                    echo "Current branch: ${env.GIT_BRANCH}"
                    sh(script: """ whoami;pwd;ls -la """, label: "first stage")
                }
            }
        }
    }
}
