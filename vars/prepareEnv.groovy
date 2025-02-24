def call() {
    def committerEmail = sh (script: 'git --no-pager show -s --format=\'%ae\'', returnStdout: true).trim()
    
    return [
        codeCommiter: committer, 
        commitHash: env.GIT_COMMIT, 
        gitUrl: env.GIT_URL
    ]
}
