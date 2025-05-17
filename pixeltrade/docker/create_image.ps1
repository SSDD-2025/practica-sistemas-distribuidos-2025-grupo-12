$DockerUser = "dmunozm5"
$ImageName = "pixeltrade"
$Tag = "1.0.0"

$FullImageName = "${DockerUser}/${ImageName}:${Tag}"

Write-Host "Building Docker image: $FullImageName"
docker build -t $FullImageName -f ./Dockerfile ..
Write-Host "Image built successfully."