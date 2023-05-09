//
//  UInt64Ext.swift
//  Clear&Clean
//
//  Created by sj on 2023/5/6.
//

import Foundation

extension UInt64{
    
    //文件大小转人类识别的大小
    func toHumanSize() -> String{
            let formatter = ByteCountFormatter()
            formatter.allowedUnits = [.useKB, .useMB, .useGB, .useTB] // 可以使用的单位
            formatter.countStyle = .file // 格式化样式
            return formatter.string(fromByteCount: Int64(self))
    }
}
