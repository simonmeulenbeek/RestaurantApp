import type { App, Component } from 'vue'
import IconCommunity from './components/icons/IconCommunity.vue'
import IconDocumentation from './components/icons/IconDocumentation.vue'
import IconEcosystem from './components/icons/IconEcosystem.vue'
import IconSupport from './components/icons/IconSupport.vue'
import IconTooling from './components/icons/IconTooling.vue'

import Header from './components/layout/Header.vue'
import Modal from './components/common/Modal.vue'
import DebugPanel from './components/debug/DebugPanel.vue'
import DebugInfo from './components/debug/DebugInfo.vue'
import StappenPlan from './components/stappenplan/StappenPlan.vue'
import ViewSwitcher from './components/ViewSwitcher.vue'
import Menu from './components/menu/Menu.vue'
import MenuItem from './components/menu/MenuItem.vue'
import AmountWidget from './components/menu/AmountWidget.vue'
import TableSelector from './components/widgets/TableSelector.vue'
import LabelValue from './components/common/LabelValue.vue'
import CurrentOrder from './components/menu/CurrentOrder.vue'
import KeyPad from './components/common/KeyPad.vue'
import IconBackspace from './components/icons/IconBackspace.vue'

const components: { [key: string]: Component } = {
    Header,
    Modal,
    KeyPad,
    DebugPanel,
    DebugInfo,
    StappenPlan,
    ViewSwitcher,
    TableSelector,
    Menu,
    MenuItem,
    CurrentOrder,
    AmountWidget,
    LabelValue,
    IconCommunity,
    IconDocumentation,
    IconEcosystem,
    IconSupport,
    IconTooling,
    IconBackspace
}

export const registerComponents = async (app: App<Element>): Promise<void> => {
    for (const item of Object.entries(components)) {
        app.component(item[0], item[1])
    }
}
