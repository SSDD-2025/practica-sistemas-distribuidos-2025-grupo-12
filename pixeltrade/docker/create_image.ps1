$DockerUser = "dmunozm5"
$ImageName = "pixeltrade"
$Tag = "latest"

$FullImageName = "$DockerUser/$ImageName:$Tag"

Write-Host "Building Docker image: $FullImageName"
docker build -t $FullImageName .
Write-Host "Image built successfully."