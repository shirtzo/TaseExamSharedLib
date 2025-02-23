def call() {
    // Checkout the repository and get the SCM information
    def scmVars = checkout([
        $class: 'GitSCM',
        branches: [[name: '*/main']],  // Adjust the branch name accordingly
        extensions: [],
        userRemoteConfigs: [[url: 'https://github.com/shirtzo/TaseExam.git']]
    ])

    // Set the retrieved values as environment variables
    env.GIT_COMMIT = scmVars.GIT_COMMIT
    env.GIT_COMMITTER_NAME = scmVars.GIT_COMMITTER_NAME

    // Print to the console for debugging
    echo "Commit hash: ${env.GIT_COMMIT}"
    echo "Committer name: ${env.GIT_COMMITTER_NAME}"
}
