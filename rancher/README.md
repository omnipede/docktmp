# Rancher

# Run
https://www.rancher.com/quick-start
```shell
$ sudo docker run --rm -d \
  --privileged \
  -p 80:80 -p 443:443 \
  -v ~/opt/rancher:/var/lib/rancher \
  rancher/rancher:latest
```

# Private registry setting

`Storage` > `Secrets` > `Create` > `Registry`

# Port forwarding

대상 클러스터의 `kube.config` 를 가져와야 한다. 클러스터 관리 화면에서 대상 클러스터의 `KubeConfig` 값을 복사하면 된다.

```shell
$ kubectl --kubeconfig ./kube.config port-forward --address=0.0.0.0 svc/nginx-deployment 8081:80
```

# Logging integration

https://ranchermanager.docs.rancher.com/pages-for-subheaders/logging

# Istio integration

https://ranchermanager.docs.rancher.com/pages-for-subheaders/istio
