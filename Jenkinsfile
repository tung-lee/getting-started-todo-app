pipeline {
    agent none  // We'll define the agent in each stage

    stages {
        stage('info') {
            agent {
                node {
                    label "${env.GIT_BRANCH == 'origin/main' ? 'production-server' : env.GIT_BRANCH == 'origin/dev' ? 'test-dev-battle-server' : 'default-agent'}"
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
