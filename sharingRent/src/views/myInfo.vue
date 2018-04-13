<template>
  <div id="app">
    <mt-header title="吉山小霸王" class="grid-title" fixed>
      <mt-button class="icon-pencil" slot="right"></mt-button>
    </mt-header>
    <div style="margin-top: 7rem;">
      <div class="div-cell">
        <mt-cell class="title-cell">
          <span slot="title">
            <mt-button type="primary">
              <i class="icon-user"></i>
              <span>我的资料</span>
            </mt-button>
          </span>
        </mt-cell>
        <mt-cell class="detail-cell">
          <span slot="title">用户名：</span>
          <span>
            <span>神奇呆</span>
            <i class="icon-pencil"></i>
          </span>
        </mt-cell>
        <mt-cell class="detail-cell">
          <span slot="title">邮　箱：</span>
          <span>
            <span>214308645@qq.com</span>
            <i class="icon-pencil"></i>
          </span>
        </mt-cell>
      </div>
      <div class="div-cell">
        <mt-cell class="title-cell">
          <span slot="title"><mt-button type="primary">
            <i class="icon-users"></i> 合租列表</mt-button></span>
        </mt-cell>
        <mt-cell class="detail-cell">
          <span slot="title">用户名单</span>
          <span style="color:#42b983;">总账单</span>
        </mt-cell>
        <mt-cell class="detail-cell">
          <span slot="title" class="mint-cell-value table-cell">呆呆1号</span>
          <span class="table-cell">应收取 呆呆2号 129元</span>
        </mt-cell>
        <mt-cell class="detail-cell">
          <span slot="title" class="mint-cell-value table-cell">呆呆2号</span>
          <span class="table-cell">应付予 呆呆1号 129元</span>
        </mt-cell>
      </div>
      <div class="div-cell">
        <mt-cell class="title-cell">
          <span slot="title"><mt-button type="primary"><i class="icon-home"></i> 每月固定费用</mt-button></span>
        </mt-cell>
        <mt-cell class="detail-cell">
          <span slot="title">房　租：</span>
          <span>1000元 <i class="icon-pencil"></i></span>
        </mt-cell>
        <mt-cell class="detail-cell">
          <span slot="title">管理费：</span>
          <span>30元 <i class="icon-pencil"></i></span>
        </mt-cell>
        <mt-cell class="detail-cell">
          <span slot="title">网　费：</span>
          <span>70元 <i class="icon-pencil"></i></span>
        </mt-cell>
        <mt-cell class="detail-cell">
          <span slot="title">其　它：</span>
          <span>70元 <i class="icon-pencil"></i></span>
        </mt-cell>
      </div>
      <div class="div-cell">
        <mt-cell class="title-cell">
          <span slot="title"><mt-button type="primary"><i class="icon-cogs"></i> 相关设置</mt-button></span>
        </mt-cell>
        <mt-cell class="detail-cell">
          <span slot="title">发送账单周期：</span>
          <span>每　周 <i class="icon-pencil"></i></span>
        </mt-cell>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      msg: 'my first try'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.grid-title{
  font-size: 4rem;
  line-height: 6.5rem;
  height: 6.5rem;
  background: #58B7FF;
  color: #FFF;
  text-align: center;
}
.text-span{
  font-size: 3rem;
  margin-left: 4rem;
}
.detail-cell{
  margin-top: 1rem;
  margin-bottom: 1rem;
  margin-left: 4rem;
}
.table-cell{
  font-size: 3rem;
  color: #888;
}
.title-cell{
  margin-bottom: 2rem;
}
.div-cell{
  margin-bottom: 3rem;
}
</style>
