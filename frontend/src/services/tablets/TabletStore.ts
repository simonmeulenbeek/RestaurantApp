import {reactive} from 'vue'
import type { TableData } from '@/types/table_data';
import type { Tablet } from '@/types/tablet';
import type { TabletRegistration } from '@/types/tablet_registration';
import type { CustomerSession } from '@/types/customer_session';

export const tabletStore = reactive<{
    enabled: boolean;
    loaded: boolean;
    tabletId: string | null;
    tablet: Tablet | null;
    table: TableData | null;
    registration: TabletRegistration | null;
    session: CustomerSession | null;
}>({
    enabled: false,
    loaded: false,
    tabletId: null,
    tablet: null,
    table: null,
    registration: null,
    session: null
})
