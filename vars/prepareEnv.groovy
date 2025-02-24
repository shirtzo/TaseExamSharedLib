def call() {
    def gitCommitHash = sh(script: "git log -n 1 --pretty=format:'%H'", returnStdout: true)
    def committerName = sh(script: "git --no-pager show -s --format='%cn' ${gitCommitHash}", returnStdout: true).trim()

    return [
        codeCommiter: committerName, 
        commitHash: env.GIT_COMMIT, 
        gitUrl: env.GIT_URL
    ]
}
