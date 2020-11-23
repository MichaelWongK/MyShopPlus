import request from '@/utils/request'

/**
 * 获取个人信息
 * @param {用户名} username 
 */
export function info(username) {
  return request({
    url: '/profile/info/' + username,
    method: 'get'
  })
}

/**
 * 修改个人信息
 * @param {用户名} profileParam 
 */
export function update(data) {
  return request({
    url: '/profile/update/',
    method: 'post',
    data
  })
}