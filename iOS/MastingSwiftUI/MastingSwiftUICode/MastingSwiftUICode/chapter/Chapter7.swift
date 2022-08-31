//
//  Chapter7.swift
//  MastingSwiftUICode
//
//  Created by sj on 2022/7/14.
//

import SwiftUI

struct Chapter7: View {
    
    
    
    var body: some View {
        
        VStack{
            Path() { path in
                path.move(to: CGPoint(x: 20, y: 20))
                path.addLine(to: CGPoint(x: 300, y: 20))
                path.addLine(to: CGPoint(x: 300, y: 200))
                path.addLine(to: CGPoint(x: 20, y: 200))
            }
            .fill(.red)
            
            Path() { path in
                path.move(to: CGPoint(x: 20, y: 20))
                path.addLine(to: CGPoint(x: 300, y: 20))
                path.addLine(to: CGPoint(x: 300, y: 200))
                path.addLine(to: CGPoint(x: 20, y: 200))
                path.closeSubpath()
            }
            .stroke(.red, lineWidth: 2)
        }
        
    }
}

struct Chapter7_Previews: PreviewProvider {
    static var previews: some View {
        Chapter7()
    }
}
