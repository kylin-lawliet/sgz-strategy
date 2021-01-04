<!DOCTYPE html>
<html lang="en">
<head>
    <#assign basePath=request.contextPath />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>阵容信息匹配</title>
</head>
<body>
    <h3>阵容匹配--小白版</h3>
    <li>配置用户拥有的武将，目前统御值，可配置队伍数</li>
    <li>找到当前最高星级武将为主将，个数为当前可匹配队伍数量</li>
    <li>根据主将从阵容匹配表中找到最佳匹配阵容(阵容表数据来源攻略文章个数太少，武将多为五星)</li>
    <li>以上找不到，再根据武将缘分表找到缘分武将(这个暂时没有，武将缘分还没有数据)</li>
    <li>以上找不到，再根据主将找两名同阵营</li>
    <li>以上找不到，再根据游戏中提供的阵容匹配</li>
    <li>以上找不到，根据剩余统御值找星级高的</li>
    <li>以上找不到，根据剩余统御值找等级高的</li>
    注：这个没有考虑到武将类型跟战法的匹配，只适合刚玩游戏又没什么星级高的英雄的小白使用。

    <h3>用户信息</h3>
    <table>
        <tr>
            <td width="150">玩家名称：</td><td width="80">admin</td>
            <td width="150">武将个数：</td><td width="80">63</td>
            <td width="150">队伍个数：</td><td width="80">10</td>
        </tr>
        <tr>
            <td>五星武将</td><td>6</td>
            <td>四星武将</td><td>10</td>
            <td>三星武将</td><td>10</td>
        </tr>
        <tr>
            <td>统御值（主城）</td><td>19</td>
            <td>统御值（分城）</td><td>13</td>
        </tr>
    </table>

    <h3>匹配结果</h3>
    <table>
        <tr>
            <th width="5%">队伍</th>
            <th width="5%">主将</th>
            <th width="10%">战法推荐</th>
            <th width="5%">副将</th>
            <th width="10%">战法推荐</th>
            <th width="5%">副将</th>
            <th width="10%">战法推荐</th>
            <th width="5%">加点推荐</th>
            <th width="10%">队伍补充</th>
        </tr>
        <tr>
            <td align="center">队伍</td>
            <td align="center">主将</td>
            <td>战法推荐,战法推荐,战法推荐</td>
            <td align="center">副将</td>
            <td>战法推荐,战法推荐,战法推荐</td>
            <td align="center">副将</td>
            <td>战法推荐,战法推荐,战法推荐</td>
            <td align="center">加点推荐</td>
            <td align="center">队伍补充</td>
        </tr>
    </table>
</body>
</html>
