<template>
  <div>
    <el-table
        :data="tableData"
        border
        style="width: 40%">
      <el-table-column
          fixed
          prop="id"
          label="id"
          width="150">
      </el-table-column>
      <el-table-column
          prop="name"
          label="姓名"
          width="120">
      </el-table-column>
      <el-table-column
          prop="age"
          label="年龄"
          width="120">
      </el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          width="100">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="deleteLX(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        background
        layout="prev, pager, next"
        page-size="3"
        :total="total"
        @current-change="page"
    >
    </el-pagination>
  </div>
</template>

<script>
export default {
  methods: {
    deleteLX(row){
      const _this=this
      axios.delete('http://localhost:8082/lx/deleteById/'+row.id).then(function (resp){
        _this.$alert(''+row.name+'删除成功！', '消息', {
          confirmButtonText: '确定',
          callback: action => {
            window.location.reload()
          }
        })
      })
    },
    edit(row) {
      this.$router.push({
        path:'/lx2',
        query:{
          id:row.id
        }
      })

/*      this.$prompt('请输入姓名', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
        inputErrorMessage: '邮箱格式不正确'
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '你的邮箱是: ' + value
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });
      });*/



    },
    page(currentPage){
      const _this=this
      axios.get('http://localhost:8082/lx/findAll/'+currentPage+'/3').then(function (resp){
        _this.tableData=resp.data.content
        _this.total=resp.data.totalElements
      })
    }
  },

  created() {
    const _this=this
    axios.get('http://localhost:8082/lx/findAll/1/3').then(function (resp){
      _this.tableData=resp.data.content
      _this.total=resp.data.totalElements
    })
  },

  data() {
    return {
      total:null,
      tableData:null
    }
  }
}
</script>