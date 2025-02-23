def call() {
    echo "Commit hash: ${env.GIT_COMMIT}"
    echo "Committer name: ${env.GIT_COMMITTER_NAME}"
    eco "git url: ${env.GIT_URL}"
}
