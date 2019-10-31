$sourcedir33= $scriptPath = split-path -parent $MyInvocation.MyCommand.Definition

Write-Output "Source Directory:"  $sourcedir33.ToString().Trim()
$sourcefile = $sourcedir33.ToString().Trim()+"\pre-commit"
Write-Output "Source folder:"  $sourcedir33.ToString().Trim()
$destfile = $sourcedir33.ToString().Trim()+"\.git\hooks"
Write-Output "Destination folder:" $sourcefile

copy-item -path $sourcefile -destination $destfile -recurse