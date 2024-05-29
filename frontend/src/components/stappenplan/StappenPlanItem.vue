<script>
export default {}
</script>

<template>
    <div class="stappen_plan_item">
        <i class="stappen_plan_item__icon">
            <slot name="icon"></slot>
        </i>
        <div class="stappen_plan_item__details">
            <h3 class="stappen_plan_item__header">
                <slot name="heading"></slot>
            </h3>
            <p class="stappen_plan_item__text">
                <slot></slot>
            </p>
        </div>
    </div>
</template>
