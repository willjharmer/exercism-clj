#!/bin/bash

echo -e "\033[0;32mDeploying updates to Github...\033[0m"

# Build the project.
hugo

# Add changes to git.
git add -A

# Commit changes.
msg="rebuilding site `date`"
if [ $# -eq 1 ]
  then msg="$1"
fi
git commit -m "$msg"

# Push source and build repos.
git push origin master
git subtree push --prefix=public git@github.com:willjharmer/exercism-python.git gh-pages

# Script created in the image of spencerlyon2's deploy.sh @https://github.com/spencerlyon2/hugo_gh_blog.git
