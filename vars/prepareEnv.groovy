def call() {
    def committerName = sh(script: "git --no-pager show -s --format='%cn' ${env.GIT_COMMIT}", returnStdout: true).trim()

    return [
        codeCommiter: committerName, 
        commitHash: env.GIT_COMMIT, 
        gitUrl: env.GIT_URL
    ]
}
