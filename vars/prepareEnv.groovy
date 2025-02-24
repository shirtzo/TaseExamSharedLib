def call() {
    def gitCommitHash = e8333ae8eeb4dc6f8b92e59c809187730ae9167b
    def committerName = sh(script: "git --no-pager show -s --format='%cn' ${gitCommitHash}", returnStdout: true).trim()

    return [
        codeCommiter: committerName, 
        commitHash: env.GIT_COMMIT, 
        gitUrl: env.GIT_URL
    ]
}
