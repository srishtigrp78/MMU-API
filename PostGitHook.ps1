$sourcedir= Get-Location

Write-Output "Source Directory:"  $sourcedir.ToString().Trim()
$sourcefile = $sourcedir.ToString().Trim()+"\pre-commit"
Write-Output "Source folder:"  $sourcedir.ToString().Trim()
$destfile = $sourcedir.ToString().Trim()+"\.git\hooks"
Write-Output "Destination folder:" $sourcefile

copy-item -path $sourcefile -destination $destfile –recurse

