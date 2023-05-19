//
//  Polygon.swift
//  Clear&Clean
//
//  Created by sj on 2023/5/18.
//

import SwiftUI


public struct Polygon: Shape {
    public var sides: Double
    public var scale: Double
    public init(sides: Double, scale: Double) {
        self.sides = sides
        self.scale = scale
    }
    public var animatableData: AnimatablePair<Double, Double> {
        get { AnimatablePair(sides, scale) }
        set {
            sides = newValue.first
            scale = newValue.second
        }
    }

    public func path(in rect: CGRect) -> Path {
        // hypotenuse
        let hypotenuse = Double(min(rect.size.width, rect.size.height)) / 2.0 * scale

        // center
        let center = CGPoint(x: rect.size.width / 2.0, y: rect.size.height / 2.0)

        var path = Path()

        let extra: Int = sides != Double(Int(sides)) ? 1 : 0

        for i in 0..<Int(sides) + extra {
            let angle = (Double(i) * (360.0 / sides)) * (Double.pi / 180)

            // Calculate vertex
            let vertex = CGPoint(x: center.x + CGFloat(cos(angle) * hypotenuse),
                                 y: center.y + CGFloat(sin(angle) * hypotenuse))

            if i == 0 {
                path.move(to: vertex) // move to first vertex
            } else {
                path.addLine(to: vertex) // draw line to next vertex
            }
        }

        path.closeSubpath()

        return path
    }
}


public struct AnyShape: Shape {
    private let _makePath: (CGRect) -> Path

    public init<S: Shape>(_ shape: S) {
        self._makePath = shape.path
    }

    public func path(in rect: CGRect) -> Path {
        self._makePath(rect)
    }
}

public extension Shape {
    func eraseToAnyShape() -> AnyShape {
        AnyShape(self)
    }
}




struct Triangle: Shape {
    func path(in rect: CGRect) -> Path {
        var path = Path()

        path.move(to: CGPoint(x: rect.midX, y: rect.minY))
        path.addLine(to: CGPoint(x: rect.minX, y: rect.maxY))
        path.addLine(to: CGPoint(x: rect.maxX, y: rect.maxY))
        path.addLine(to: CGPoint(x: rect.midX, y: rect.minY))

        return path
    }
}
