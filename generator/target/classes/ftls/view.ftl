<template>
  <div class="app-container">
    <!--搜索栏-->
    <div class="filter-container">
      <el-input :placeholder="$t('${EntityName}.${EntityName}Name')" v-model="listQuery.${EntityName}Name" style="width: 200px;" class="filter-item" @keyup.enter.native="handleFilter"/>
      <el-select v-model="listQuery.status" :placeholder="$t('${EntityName}.status')" clearable style="width: 90px" class="filter-item">
        <el-option v-for="(item, index) in statusOptions" :key="index" :label="item" :value="index">{{ item }}</el-option>
      </el-select>
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">{{ $t('common.search') }}</el-button>
      <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="handleCreate">{{ $t('common.add') }}</el-button>
    </div>
    <!--表格栏-->
    <el-table
      v-loading="listLoading"
      :key="tableKey"
      :data="list"
      border
      fit
      sortable
      highlight-current-row
      style="width: 100%;height: 500px;overflow: auto">
      <el-table-column :label="$t('common.orderNum')" type="index" header-align="center" align="center" width="50px">
        <template slot-scope="scope">
          <span>{{ scope.$index + 1 }}</span>
        </template>
      </el-table-column>
      <el-table-column :label="$t('${EntityName}.${EntityName}No')" width="150px" align="center">
        <template slot-scope="scope">
          <span class="link-type" @click="handleUpdate(scope.row)">{{ scope.row.${EntityName}No }}</span>
        </template>
      </el-table-column>
      <el-table-column :label="$t('${EntityName}.${EntityName}Name')" width="200px" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.${EntityName}Name }}</span>
        </template>
      </el-table-column>
      <el-table-column :label="$t('${EntityName}.status')" class-name="status-col" width="150" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status | statusFilter">{{ statusOptions[scope.row.status] }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column :label="$t('common.createDate')" width="200px" align="center" sortable>
        <template slot-scope="scope">
          <span>{{ scope.row.createDate }}</span>
        </template>
      </el-table-column>
      <el-table-column :label="$t('common.createBy')" width="120px" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.createBy }}</span>
        </template>
      </el-table-column>
      <el-table-column :label="$t('common.updateDate')" width="200px" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.updateDate }}</span>
        </template>
      </el-table-column>
      <el-table-column :label="$t('common.updateBy')" width="120px" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.updateBy }}</span>
        </template>
      </el-table-column>

      <el-table-column :label="$t('common.actions')" align="center" width="230" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">{{ $t('common.edit') }}</el-button>
          <el-button v-if="scope.row.status!='1'" size="mini" type="warning" @click="handleModifyStatus(scope.row,1)">
            {{ $t('common.forbidden') }}
          </el-button>
          <el-button v-if="scope.row.status!='2'" size="mini" type="danger" @click="handleModifyStatus(scope.row,2)">
            {{ $t('common.delete') }}
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--分页栏-->
    <pagination v-show="total>0" :total="total" :page.sync="listQuery.pageNo" :limit.sync="listQuery.pageSize" @pagination="getList" />
    <!--编辑页面-->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item>
          <el-input v-model="temp.id" style="display: none;"/>
        </el-form-item>
        <el-form-item :label="$t('${EntityName}.${EntityName}No')" prop="${EntityName}No">
          <el-input :autosize="{ minRows: 2, maxRows: 50}" v-model="temp.${EntityName}No"/>
        </el-form-item>
        <el-form-item :label="$t('${EntityName}.${EntityName}Name')" :autosize="{ minRows: 2, maxRows: 50}" prop="${EntityName}Name">
          <el-input v-model="temp.${EntityName}Name"/>
        </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">{{ $t('common.cancel') }}</el-button>
        <el-button type="primary" @click="dialogStatus==='create'?createData():updateData()">{{ $t('common.confirm') }}</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import waves from '@/directive/waves'
import request from '@/utils/request'
import Pagination from '@/components/Pagination'
export default {
  name: '${ClassName}Table',
  components: { Pagination },
  directives: { waves },
  filters: {
    statusFilter(status) {
      const statusArray = ['success', 'danger', 'info']
      return statusArray[status]
    }
  },
  data() {
    return {
      tableKey: 0,
      list: null,
      total: 0,
      listLoading: true,
      listQuery: {
        pageNo: 1,
        pageSize: 10,
        ${EntityName}Name: undefined,
        ${EntityName}No: undefined,
        status: undefined
      },
      statusOptions: this.$t('${EntityName}.statusOptions'),
      //isSysOptions: this.$t('dict.isSysOptions'),
      temp: {
        id: undefined,
        ${EntityName}No: '',
        ${EntityName}Name: '',
      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: this.$t('common.edit'),
        create: this.$t('common.add')
      },
      rules: {
          ${EntityName}No: [{ required: true, message: this.$t('${EntityName}.rulesPrompt.${EntityName}No'), trigger: 'change' }],
          ${EntityName}Name: [{ required: true, message: this.$t('${EntityName}.rulesPrompt.${EntityName}Name'), trigger: 'change' }]
      },
      downloadLoading: false
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      request({
        url: 'admin/${EntityName}/page',
        params: this.listQuery
      }).then(response => {
        this.list = response.data.records
        this.total = response.data.total

        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
      })
    },
    handleFilter() {
      this.listQuery.pageNo = 1
      this.getList()
    },
    handleModifyStatus(row, status) {
      request({
        url: '/admin/${EntityName}/selective',
        method: 'put',
        headers: {
          'Content-Type': 'application/json'
        },
        data: JSON.stringify({ id: row.id, status: status })
      }).then(() => {
        if (status === 2) {
          this.getList()
        } else {
          row.status = status
        }
        this.$message({
          title: this.$t('common.success'),
          message: this.$t('common.handleSuccess'),
          type: 'success',
          duration: 2000
        })
      })
    },
    resetTemp() {
      this.temp = {
        id: undefined,
        ${EntityName}No: '',
        ${EntityName}Name: '',
        status: 0
      }
    },
    handleCreate() {
      this.resetTemp()
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    createData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          request({
            url: '/admin/${EntityName}',
            method: 'post',
            headers: {
              'Content-Type': 'application/json'
            },
            data: JSON.stringify(this.temp)
          }).then(() => {
            this.list.unshift(this.temp)
            this.dialogFormVisible = false
            this.$message({
              title: this.$t('common.success'),
              message: this.$t('common.handleSuccess'),
              type: 'success',
              duration: 2000
            })
          })
        }
      })
    },
    linkDetail(row) {
      this.$router.push({ name: 'dictDetail', params: { dictId: row.id }})
    },
    handleUpdate(row) {
      this.temp = Object.assign({}, row)
      //this.temp.isSys = parseInt(this.temp.isSys)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    updateData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          const tempData = Object.assign({}, this.temp)
          request({
            url: '/admin/${EntityName}/selective',
            method: 'put',
            headers: {
              'Content-Type': 'application/json'
            },
            data: JSON.stringify(tempData)
          }).then(() => {
            for (const v of this.list) {
              if (v.id === this.temp.id) {
                const index = this.list.indexOf(v)
                this.list.splice(index, 1, this.temp)
                break
              }
            }
            this.dialogFormVisible = false
            this.$message({
              title: this.$t('common.success'),
              message: this.$t('common.handleSuccess'),
              type: 'success',
              duration: 2000
            })
          })
        }
      })
    },
    handleDelete(row) {
      this.$message({
        title: this.$t('common.success'),
        message: this.$t('common.handleSuccess'),
        type: 'success',
        duration: 2000
      })
      const index = this.list.indexOf(row)
      this.list.splice(index, 1)
    }
  },
  sortCreateDate() {
  }
}
</script>
