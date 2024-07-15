pipeline {
	agent any

	environment {
		NEW_VERSION = '1.3.0'
		SERVER_CREDENTIALS = credentials('server-credentials')
		AWS = credentials('aws')
	}

	stages {
		stage('webhook') {
			steps {
				echo 'webhook...'
			}
		}
		
		stage('build') {
			when {
				expression {
					BRANCH_NAME == 'dev'
				}
			}
			
			steps {
				echo 'build...'
			}
		}

		stage('test') {
			steps {
				echo 'test...'
				echo "test version ${NEW_VERSION}"
			}
		}

		stage('deploy') {	
			steps {
				echo 'deploy...'
				withCredentials([
            usernamePassword(credentialsId: 'server-credentials',
              usernameVariable: 'username',
              passwordVariable: 'password')
          ]) {
            print 'username=' + username + 'password=' + password

            print 'username.collect { it }=' + username.collect { it }
            print 'password.collect { it }=' + password.collect { it }
          }

withCredentials([
            sshUserPrivateKey(
              credentialsId: 'aws',
              keyFileVariable: 'keyFile',
              usernameVariable: 'username')
          ]) {
            print 'keyFile=' + keyFile
            print 'username=' + username
            print 'keyFile.collect { it }=' + keyFile.collect { it }
            print 'username.collect { it }=' + username.collect { it }
            print 'keyFileContent=' + readFile(keyFile)
          }
				
				
			}
		}
	}

	post {
		always {
			echo 'finally...'
		}
	}
}
