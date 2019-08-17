<template>
    <div>
        <router-link :to="path">
          <span class="option">
            {{ label }}
          </span>
        </router-link>
    </div>
</template>
<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator'

@Component
export default class LinkMenu extends Vue {
   @Prop() label?: string; 
   @Prop() path?: string;
}
</script>
<style lang="sass" scoped>
.option
  color: #FFFFFF
  display: block
  padding: 0 15px
  &:hover
    color: #b7e3ff
.router-link-active
  font-size: 22px
  text-transform: uppercase    
</style>


