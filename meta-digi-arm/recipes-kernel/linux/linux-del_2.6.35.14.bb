# Copyright (C) 2012 Digi International

include linux-del.inc

PR = "${INC_PR}.0"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}_${PV}"

SRCREV_mx5 = "${AUTOREV}"
LOCALVERSION_mx5 = "mx5+master"

KERNEL_CFG_FRAGS_mx5 = "file://config-accel-module.cfg file://config-sahara-module.cfg file://config-camera-module.cfg"
KERNEL_CFG_FRAGS_ccimx51js_mx5 = "file://config-battery-module.cfg"
SRC_URI = "${DIGI_LOG_GIT}linux-2.6.git;protocol=git;branch=refs/heads/master \
           file://defconfig \
	   ${KERNEL_CFG_FRAGS} \
"
# Override 'ccardimx28js' SRC_URI so the 'SRC_URI_append_mxs' patches
# from FSL layer are *not* applied
SRCREV_mxs = "${AUTOREV}"
LOCALVERSION_mxs = "mxs+master"
KERNEL_CFG_FRAGS_ccardimx28js_mxs = "${@base_contains('DISTRO_FEATURES', 'x11', 'file://config-fb.cfg file://config-touch.cfg', '', d)}"
KERNEL_CFG_FRAGS_ccardimx28js_mxs += "${@base_contains('MACHINE_FEATURES', 'alsa', 'file://config-sound.cfg', '', d)}"
SRC_URI_ccardimx28js_mxs = "${DIGI_LOG_GIT}linux-2.6.git;protocol=git;branch=refs/heads/master \
           file://defconfig \
	   ${KERNEL_CFG_FRAGS} \
"
SRCREV_mxs = "${AUTOREV}"
LOCALVERSION_cpx2 = "mxs+gateways_master"
SRC_URI_cpx2_mxs = "${DIGI_LOG_GIT}linux-2.6.git;protocol=git;branch=refs/heads/gateways/master \
           file://defconfig \
"

FILES_kernel-image += "/boot/config*"

COMPATIBLE_MACHINE = "(mxs|mx5)"