SUMMARY = "Tensor Interface Module for OpenVX"
DESCRIPTION = "TIM-VX is a software integration module provided by VeriSilicon \
to facilitate deployment of Neural-Networks on OpenVX enabled ML accelerators. It serves as \
the backend binding for runtime frameworks such as Android NN, Tensorflow-Lite, MLIR, TVM and more."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ededf2503f5d147ae718276dfd28801f"

DEPENDS = "imx-gpu-viv nn-imx"

TIM_VX_SRC ?= "git://github.com/nxpmicro/tim-vx-imx.git;protocol=https"
SRCBRANCH = "imx-v1.1.y"
SRCREV = "75e94b3d9f005ab6ae095bf33c6a994925b5dc6c" 
SRC_URI = "${TIM_VX_SRC};branch=${SRCBRANCH} \
    file://0001-CMakeLists.txt-Use-CMAKE-installation-variables.patch"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE =  " \
    -DCONFIG=YOCTO \
    -DTIM_VX_ENABLE_TEST=off \
    -DTIM_VX_USE_EXTERNAL_OVXLIB=on \
    -DOVXLIB_INC=${PKG_CONFIG_SYSROOT_DIR}/usr/include/OVXLIB \
"

# Output library is unversioned
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

COMPATIBLE_MACHINE          = "(^$)"
COMPATIBLE_MACHINE:imxgpu3d = "(mx8)"
COMPATIBLE_MACHINE:mx8mm    = "(^$)"