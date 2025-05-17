$DockerUser = "dmunozm5"
$ImageName = "pixeltrade"
$Tag = "latest"

$FullImageName = "$DockerUser/$ImageName:$Tag"

Write-Host "Publishing $ImageName as OCI Artifact to $FullImageName"

docker compose publish $FullImageName

Write-Host "Published successfully!" -ForegroundColor Green

