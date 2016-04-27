GPU_PKGS = ""
GPU_PKGS_mx6 = "imx-gpu-viv-tools-apitrace"

XWAYLAND_PKGS = ""
XWAYLAND_PKGS_mx6 = "${@base_contains('DISTRO_FEATURES', 'wayland', \
                                      base_contains('DISTRO_FEATURES', 'x11','xserver-xorg-xwayland', '', d), '',d)}"
SOC_TOOLS_GPU_append_mx6 = " ${GPU_PKGS} ${XWAYLAND_PKGS}"

XWAYLAND = "${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'xserver-xorg-extension-viv-autohdmi', '', d)}"

SOC_TOOLS_GPU_remove_mx6 = "${XWAYLAND} fsl-gpu-sdk"

SOC_TOOLS_GPU_append_mx6 = " imx-gpu-sdk"
