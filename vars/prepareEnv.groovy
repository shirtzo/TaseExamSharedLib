def call() {
    sh 'echo "GIT_COMMITTER_NAME=$(git show -s --pretty=%cn)" > $WORKSPACE/envvars'
    def committer = sh(script: ". $WORKSPACE/envvars && echo \$GIT_COMMITTER_NAME", returnStdout: true).trim()
    
    return [
        codeCommiter: committer, 
        commitHash: env.GIT_COMMIT, 
        gitUrl: env.GIT_URL
    ]
}