def call() {
    def committer = sh(script: "git show -s --format=\"%cn\" ${GIT_COMMIT}", returnStdout: true).trim()
    
    return [
        codeCommiter: committer, 
        commitHash: env.GIT_COMMIT, 
        gitUrl: env.GIT_URL
    ]
}
