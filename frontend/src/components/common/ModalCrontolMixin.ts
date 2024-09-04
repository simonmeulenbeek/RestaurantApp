import { defineComponent } from 'vue'
export const ModalControlMixin =  defineComponent({
    inject: [
        'modalClose',
        'modalOpen',
        'modalToggle',
        'modalComplete',
        'modalAbort'
    ],
    props: {
        onOpen: {
			type: Function,
			required: false
		},
		onClose: {
			type: Function,
			required: false
		},
		onAbort: {
			type: Function,
			required: false
		},
		onComplete: {
			type: Function,
			required: false
		}
    },
    methods: {
        openModal: function() {
            console.log("ModalControlMixin - open modal");
            this.modalOpen?.();
        },
        abortModal: function() {
            console.log("ModalControlMixin - abort modal");
            this.modalAbort?.();
        },
        closeModal: function() {
            console.log("ModalControlMixin - close modal");
            this.modalClose?.();
        },
        completeModal: function() {
            console.log("ModalControlMixin - complete modal");
            this.modalComplete?.();
        }
    }
});