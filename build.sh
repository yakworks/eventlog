#!/usr/bin/env bash
# --------------------------------------------
# main bash build script for CI, dev and releasing. make calls this too.
# --------------------------------------------

set -e
# if build/bin does not exists then clone the bin scripts
[ ! -e build/bin ] && git clone https://github.com/yakworks/bin.git build/bin --single-branch --depth 1;
# user.env overrides for local dev, not to be checked in
[[ -f user.env ]] && source user.env
# import build_functions.sh which has the the other source imports for functions
source build/bin/all.sh

# build vars
setVar PROJECT_NAME 'eventlog'

create_yml_variables gradle/build.yml
setVar RELEASABLE_BRANCHES "$git_releasableBranchRegex"
setVar GITHUB_FULLNAME "$github_fullName"
setVar CHANGELOG_NAME "docs/release-notes.md"

# cats key files into a cache-checksum.tmp file for circle to use as key
# change this based on how project is structured
function catKeyFiles {
  cat gradle.properties plugin/build.gradle examples/test-app/build.gradle > cache-checksum.tmp
}

# compile used for circle
function compile {
  # Downloads Dependencies
  ./gradlew resolveConfigurations
  ./gradlew classes
  ./gradlew testClasses
  # ./gradlew integrationTestClasses
}

# check used for circle
function check {
  ./gradlew check --max-workers=2
}

# helper/debug function ex: `build.sh logVars test sqlserver`
function logVars {
  # initEnv ${1:-dev} ${2:-mysql}
  for varName in $BUILD_VARS; do
    echo "$varName = ${!varName}"
  done
}

# --- boiler plate function runner, stay at end of file ------
if declare -f "$1" > /dev/null; then
  "$@" #call function with arguments verbatim
else
  [ "$1" ] && echo "'$1' is not a known function name" >&2 && exit 1
fi
