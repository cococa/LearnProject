//
//  Chapter8.swift
//  MastingSwiftUICode
//
//  Created by sj on 2021/8/12.
//

import SwiftUI

struct Chapter8: View {
    
    @State var isShowing : Bool = false
    
    var body: some View {
//        Path() { path in
//            path.move(to: CGPoint(x: 20, y: 20))
//            path.addLine(to: CGPoint(x: 300, y: 20))
//            path.addLine(to: CGPoint(x: 300, y: 200))
//            path.addLine(to: CGPoint(x: 20, y: 200))
//        }.fill(Color.red)
//
        
        ZStack{
            let x = 100;
            let y = 100;
            
            Path(){ p in
                p.move(to: CGPoint(x: x, y: y))
                p.addArc(center: .init(x: x, y: y), radius: 100, startAngle: Angle(degrees: 0), endAngle: Angle(degrees: 90), clockwise: true)
            }.fill(Color.green)
            .animation(.easeInOut)
        
            Button(action: {
                isShowing.toggle();
            }, label: {
                Path(){ p in
                    p.move(to: CGPoint(x: x, y: y))
                    p.addArc(center: .init(x: x, y: y), radius: isShowing ? 120 : 100, startAngle: Angle(degrees: 90), endAngle: Angle(degrees: 360), clockwise: false)
                }.stroke(Color.purple)
                .animation(.easeInOut)
            })
            
        }
        
    }
}

struct Chapter8_Previews: PreviewProvider {
    static var previews: some View {
        Chapter8()
    }
}
