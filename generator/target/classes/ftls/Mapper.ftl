<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${BasePackageName}mapper.${ClassName}Mapper">

    <resultMap id="BaseResultMap" type="${BasePackageName}bean.${EntityPackageName}.${ClassName}">
        ${ResultMap}
        ${Association}
        ${Collection}
    </resultMap>
    <sql id="Base_Column_List">
        ${ColumnMap}
    </sql>

    <!-- 分页查询 -->
    <select id="listByPage" parameterType="java.lang.Integer" resultMap="BaseResultMap">
        SELECT
        <include refid="Base_Column_List" />
        FROM ${TableName}
        <where>
          <!-- where条件 -->
        </where>
        LIMIT ${limit}
    </select>

    <!-- 条目数 -->
    <select id="count" resultType="java.lang.Integer" parameterType="java.util.Map">
        SELECT COUNT(*) FROM ${TableName}
        <where>
            <!-- where条件 -->
        </where>
    </select>

    <!-- 数据插入 -->
    <insert id="insert" keyColumn="id" keyProperty="id" parameterType="${BasePackageName}bean.entity.${ClassName}" useGeneratedKeys="true">
        INSERT INTO ${TableName}
        ( ${InsertProperties} )
        VALUES
        (  ${InsertValues} )
    </insert>

    <!-- 选择性更新 -->
    <update id="updateByPkSelective" parameterType="com.cc.admin.web.sys.bean.entity.${ClassName}">
        UPDATE ${TableName}
        <set>
          <!-- 更新的字段 -->
          ${UpdateParam}
        </set>
        WHERE id = ${Id}
    </update>

    <!-- 根据id查找详情 -->
    <select id="selectByPk" resultMap="BaseResultMap"  parameterType="java.util.Map">
        SELECT
        <include refid="Base_Column_List"/>
        FROM ${TableName} WHERE id = ${Id} AND status != 2
        <if test="orgCode != null">
            AND org_code = ${orgCode}
        </if>
        <if test="langFlag != null">
            AND lang_flag = ${langFlag}
        </if>
    </select>

    <!-- 根据id单个删除 (物理删除) -->
    <delete id="deleteByPk" parameterType="java.lang.Integer">
      DELETE FROM ${TableName}
      WHERE id = ${Id}
    </delete>

    <!-- 根据id批量删除(物理删除) -->
    <delete id="deleteByPks" parameterType="java.util.List">
      DELETE FROM ${TableName}
      WHERE id IN
          <foreach collection="list" item="id" open="(" separator=","  close=")">
            ${Id}
          </foreach>
    </delete>

</mapper>