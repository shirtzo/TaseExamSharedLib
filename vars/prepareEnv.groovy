def call() {
    def committerEmail = sh(script: "git --no-pager show -s --format='%ae' ${env.GIT_COMMIT}", returnStdout: true).trim()

    return [
        codeCommiter: committerEmail, 
        commitHash: env.GIT_COMMIT, 
        gitUrl: env.GIT_URL
    ]
}
