<template>
  <div class="app-container">
    <el-form ref="form" :data="form" :model="form" label-width="120px">
      <el-form-item label="头像">
        <img :src="form.icon" width="60" height="60">
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="form.username" />
      </el-form-item>
      <el-form-item label="中文名">
        <el-input v-model="form.nickName" />
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { info } from '@/api/profile'

export default {
  name: "ProfileInfo",
  data() {
    return {
      form: {
        id: '',
        icon: '',
        username: '',
        email: '',
        nickName: '',
        note: '',
        createTime: '',
        loginTime: '',
        status: ''
      }
    };
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      info(this.$store.getters.name).then(response => {
        this.form = response.data
        console.log('777', this.form)
      })
    }
  }
};
</script>
