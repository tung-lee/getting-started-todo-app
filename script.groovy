def buildApp() {
  echo 'build...'
}

def testApp() {
  echo 'test...'
	echo "test version ${NEW_VERSION}"
	echo "${params.VERSION}"
}

return this
