def call() {
    def committer = sh(script: "git log -1 --format='%cn'", returnStdout: true).trim()

    return [
        codeCommiter: env.GIT_COMMITER_NAME, 
        commitHash: env.GIT_COMMIT, 
        gitUrl: env.GIT_URL
    ]
}
