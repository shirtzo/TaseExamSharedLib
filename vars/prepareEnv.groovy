def call() {
    def committer = sh(script: "git log -1 --format='%cn'", returnStdout: true)

    return [
        codeCommiter: committer, 
        commitHash: env.GIT_COMMIT, 
        gitUrl: env.GIT_URL
    ]
}
